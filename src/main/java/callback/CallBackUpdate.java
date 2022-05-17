package callback;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import struct.BITMAP_UPDATE;
import struct.rdp_context;

import java.util.logging.Logger;

public class CallBackUpdate {

    public static Logger log = Logger.getLogger(CallBackUpdate.class.getSimpleName());

    public interface CLibrary extends Library {

        public interface pBitmapUpdate extends Callback {
            boolean apply3(rdp_context context, BITMAP_UPDATE bitmap);
        }

        public static class pBitmapUpdateImpl implements pBitmapUpdate {
            @Override
            public boolean apply3(rdp_context context, BITMAP_UPDATE bitmap){
                log.info("콜백작동");

                return true;
            }
        }

    }


    static public void main(String argv[]) {

        CLibrary clib = (CLibrary) Native.loadLibrary("/Users/kimfk567/Documents/IntelliSave/FreeRDP-Mac2/client/Mac/cli/MacFreeRDP.app/Contents/MacOS/MacFreeRDP", CLibrary.class);

        // instantiate a callback wrapper instance
        CLibrary.pBitmapUpdateImpl callbackImpl = new CLibrary.pBitmapUpdateImpl();

        // pass the callback wrapper to the C library



    }
}
