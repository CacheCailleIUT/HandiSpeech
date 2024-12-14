import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActiveListener implements Listener{

    private LiveSpeechRecognizer recognizer;
    private Configuration configuration;
    private final Logger logger = Logger.getLogger(getClass().getName());
    private final ExecutorService eventsExecutorService = Executors.newFixedThreadPool(2);


    private boolean ignoreSpeechRecognitionResults = false;


    private boolean speechRecognizerThreadRunning = false;

    private String speechRecognitionResult;

    private boolean resourcesThreadRunning;

    private Writer writer;

    @Override
    public void setSTTModel() {
        configuration.setAcousticModelPath("file:SpeechToText/src/main/java/frstt/cmusphinx-fr-ptm-8khz-5.2");
        configuration.setDictionaryPath("file:SpeechToText/src/main/java/frstt/fr.dict");
        configuration.setLanguageModelPath("file:SpeechToText/src/main/java/frstt/fr-small.lm.bin");
    }

    @Override
    public void setGrammar() {
        // Not used for the moment.
        // configuration.setGrammarPath("");
        // configuration.setGrammarName("");
        // configuration.setUseGrammar(true);
    }

    @Override
    public void startSpeechRecognition() {
        if (speechRecognizerThreadRunning)
            logger.log(Level.INFO, "Speech Recognition Thread already running...\n");
        else
            //Submit to ExecutorService
            eventsExecutorService.submit(() -> {

                //locks
                speechRecognizerThreadRunning = true;
                ignoreSpeechRecognitionResults = false;

                //Start Recognition
                recognizer.startRecognition(true);

                //Information
                logger.log(Level.INFO, "You can start to speak...\n");

                try {
                    while (speechRecognizerThreadRunning) {
                        /*
                         * This method will return when the end of speech is reached. Note that the end pointer will determine the end of speech.
                         */
                        SpeechResult speechResult = recognizer.getResult();

                        //Check if we ignore the speech recognition results
                        if (!ignoreSpeechRecognitionResults) {

                            //Check the result
                            if (speechResult == null)
                                logger.log(Level.INFO, "I can't understand what you said.\n");
                            else {

                                //Get the hypothesis
                                speechRecognitionResult = speechResult.getHypothesis();

                                //Call the appropriate method
                                writer.print(speechRecognitionResult);
                                writer.print("test : "+ speechResult.getResult().getBestFinalResultNoFiller());

                            }
                        } else
                            logger.log(Level.INFO, "Ingoring Speech Recognition Results...");

                    }
                } catch (Exception ex) {
                    logger.log(Level.WARNING, null, ex);
                    speechRecognizerThreadRunning = false;
                }

                logger.log(Level.INFO, "SpeechThread has exited...");

            });
    }

    @Override
    public void startResourcesThread() {
        if (resourcesThreadRunning)
            logger.log(Level.INFO, "Resources Thread already running...\n");
        else
            //Submit to ExecutorService
            eventsExecutorService.submit(() -> {
                try {

                    //Lock
                    resourcesThreadRunning = true;

                    // Detect if the microphone is available
                    while (true) {

                        //Is the Microphone Available
                        if (!AudioSystem.isLineSupported(Port.Info.MICROPHONE))
                            logger.log(Level.INFO, "Microphone is not available.\n");

                        // Sleep some period
                        Thread.sleep(350);
                    }

                } catch (InterruptedException ex) {
                    logger.log(Level.WARNING, null, ex);
                    resourcesThreadRunning = false;
                }
            });
    }

    ActiveListener() {
        writer = new Writer();
        configuration = new Configuration();
        setSTTModel();
        setGrammar();

        try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        //Check if needed resources are available
        startResourcesThread();
        //Start speech recognition thread
        startSpeechRecognition();
    }

    public static void main(String[] args) {
       new ActiveListener();
    }
}
