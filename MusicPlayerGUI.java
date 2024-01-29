
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class MusicPlayerGUI extends JFrame {
    //color configs
    public static final Color FRAME_COLOR = Color.BLACK;
    public static final Color TEXT_COLOR = Color.WHITE;
    private final javax.swing.JFileChooser JFileChooser;
    private MusicPlayer musicPlayer;

    //allow us to use file explorer in our app
    private JFileChooser JfileChooser;


    public MusicPlayerGUI() {
        //calls JFrame constructor to configure out gui and set the title header to "Music Player"
        super.setTitle("Music Player");
        //set the width and height
        setSize(400, 600);
        //end process when app is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //launch the app at the centre of the screen
        setLocationRelativeTo(null);
        //prevent the app from being resized
        setResizable(false);
        //set layout to null which allows us to control the (x ,y)coordinates of our components
        //and also set the height and width
        setLayout(null);

        //change the frame
        getContentPane().setBackground(FRAME_COLOR);

        musicPlayer=new MusicPlayer();


        JFileChooser=new JFileChooser();
        //set a default path for file explorer
        JFileChooser.setCurrentDirectory(new File("out/production/Music/src/assets/drive-download-20240126T162152Z-001"));


        addGuiComponents();
    }

    private void addGuiComponents() {
        //add toolbar
        addToolbar();
        //Load record image
        JLabel songImage = new JLabel(loadImage("out/production/Music/src/assets/drive-download-20240126T162152Z-001/record.png"));
        songImage.setBounds(0, 50, getWidth() - 20, 225);
        add(songImage);

        //song title
        JLabel songTitle = new JLabel("Song Title");
        songTitle.setBounds(0, 285, getWidth() -10, 30);
        songTitle.setFont(new Font("Dialog",Font.BOLD,24));
        songTitle.setForeground(TEXT_COLOR);
        songTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(songTitle);


        //song artist
        JLabel songArtist=new JLabel("Artist");
        songArtist.setBounds(0 , 315 , getWidth()-10,30);
        songArtist.setFont(new Font("Dialog",Font.PLAIN,24));
        songArtist.setForeground(TEXT_COLOR);
        songArtist.setHorizontalAlignment(SwingConstants.CENTER);
        add(songArtist);

        //playback slider
        JSlider playbackSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
        playbackSlider.setBounds(getWidth()/2 - 300/2, 365, 300,40);
        playbackSlider.setBackground(null);
        add(playbackSlider);


        //playback buttons
        addPlaybackButtons();

    }


    private void addToolbar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0, 0, getWidth(), 20);
        //prevent toolbar from, being moved
        toolBar.setFloatable(false);
        //add drop down menu
        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);
        //now we will add a song where we will place the loading song option
        JMenu songMenu = new JMenu("Song");
        menuBar.add(songMenu);

        //add the "Load song"item in the song menu
        JMenuItem loadSong = new JMenuItem("Load Song");
        loadSong.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFileChooser.showOpenDialog(MusicPlayerGUI.this);
                File selectedFile = JFileChooser.getSelectedFile();

                if(selectedFile!= null){
                    Song song= new Song(selectedFile.getPath());
                    //load song in music player
                    musicPlayer.loadSong(song);
                }
            }
        });
        songMenu.add(loadSong);
        //add the playlist menu
        JMenu playListMenu = new JMenu("Playlist");
        menuBar.add(playListMenu);
        // then add the items to the playlist menu
        JMenuItem createPlayList = new JMenuItem("Create Playlist");
        playListMenu.add(createPlayList);
        JMenuItem loadPlaylist = new JMenuItem("Load Playlist");
        playListMenu.add(loadPlaylist);
        add(toolBar);
    }


    private void addPlaybackButtons() {
        JPanel playbackBtns = new JPanel();
        playbackBtns.setBounds(0, 435 , getWidth() - 10, 80);
        playbackBtns.setBackground(null);

        //previous button
        JButton prevButton = new JButton(loadImage("out/production/Music/assets/drive-download-20240126T162152Z-001/previous.png"));
        prevButton.setBorderPainted(false);
        prevButton.setBackground(null);
        playbackBtns.add(prevButton);

        JButton playButton = new JButton(loadImage("out/production/Music/assets/drive-download-20240126T162152Z-001/play.png"));
        playButton.setBorderPainted(false);
        playButton.setBackground(null);
        playbackBtns.add(playButton);

        //pause button

        JButton pauseButton=new JButton(loadImage("out/production/Music/assets/drive-download-20240126T162152Z-001/pause.png"));
        pauseButton.setBorderPainted(false);
        pauseButton.setBackground(null);
        pauseButton.setVisible(false);
        playbackBtns.add(pauseButton);

        //next button
        JButton nextButton = new JButton(loadImage("out/production/Music/assets/drive-download-20240126T162152Z-001/next.png"));
        nextButton.setBorderPainted(false);
        nextButton.setBackground(null);
        playbackBtns.add(nextButton);

        add(playbackBtns);


    }



    private ImageIcon loadImage(String imagePath) {
        try {
            // Read the image file from the given path
            BufferedImage image = ImageIO.read(new File(imagePath));
            return new ImageIcon(image);
        } catch (Exception e) {
            // Print the stack trace for debugging purposes
            e.printStackTrace();
        }
        // Return null in case of an exception
        return null;
    }
}