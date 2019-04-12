package OtrosOperaciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sonidos {
    public static void reproducirSonido(String ruta){
    
        FileInputStream reproducir;
        File fichero=new File("src/sonidos/"+ruta);
        try {
            reproducir=new FileInputStream(fichero);
            AudioStream  audio =new AudioStream(reproducir);
            AudioPlayer.player.start(audio);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
           System.out.println(e.getMessage());
        }
        
    }
}
