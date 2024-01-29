import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MusicPlayer {
    //we will create a song class so as to store our song details
    private Song currentSong;
    //use Jlayer library to create an advanced player object which will handle playing the music
    private AdvancedPlayer advancedPlayer;
    //constructor
    public MusicPlayer(){

    }
    public void loadSong(Song song){
        currentSong= song;
        //play the current song if not null
        if(currentSong!= null)
        {
            playCurrentSong();
        }
    }
    public void playCurrentSong(){
        try{
            //read mp3 audio data
            FileInputStream fileInputStream=new FileInputStream(currentSong.getFilePath());
            BufferedInputStream bufferedInputStream= new BufferedInputStream(fileInputStream);

            //create a new advanced player
            advancedPlayer=new AdvancedPlayer(bufferedInputStream);

            //start music

           startMusicThread();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //create a thread that will handle playing the music
    private void startMusicThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //play music
                    advancedPlayer.play();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
