import javax.swing.*;

public class App {
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new MusicPlayerGUI().setVisible(true);
                Song song = new Song("Music/src/assets/drive-download-20240126T162152Z-001/Wind Riders - Asher Fulero.mp3");
                System.out.println(song.getSongTitle());
                System.out.println(song.getSongArtist());
            }
        });
    }
}
