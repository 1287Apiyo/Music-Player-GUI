
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;
public class MusicPlayerGUI extends JFrame {
    //color configs
    public static final Color FRAME_COLOR = Color.BLACK;
    public static final Color TEXT_COLOR = Color.WHITE;

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


        addGuiComponents();
    }

    private void addGuiComponents() {
        //add toolbar
        addToolbar();
        //Load record image
        JLabel songImage = new JLabel(loadImage("drive-download-20240126T162152Z-001/record.png"));
        songImage.setBounds(0, 50, getWidth() - 20, 225);
        add(songImage);
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
        JMenuItem LoadSong = new JMenuItem("Load Song");
        songMenu.add(LoadSong);
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
