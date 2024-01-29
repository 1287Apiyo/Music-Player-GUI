import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.VbriFrame;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.io.File;

//class used to describe a song
public class Song {
    private String songTitle;
    private String songArtist;
    private String songLength;
    private String filePath;


    public Song(String filePath){
        this.filePath=filePath;
        try{
            AudioFile audioFile = AudioFileIO.read(new File(filePath));

            //read through the metadata of the audio file
          Tag tag =audioFile.getTag();
          if (tag!=null){
              songTitle=tag.getFirst(FieldKey.TITLE);
              songArtist= tag.getFirst(FieldKey.ARTIST);
          }else{
              //could not read through MP3 files
              songTitle="N/A";
              songArtist="N/A";

          }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
//getters

    public String getSongTitle() {
        return songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongLength() {
        return songLength;
    }

    public String getFilePath() {
        return filePath;
    }

    public VbriFrame getMp3File() {
        return null;
    }
}
