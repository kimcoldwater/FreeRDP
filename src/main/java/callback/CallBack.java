package callback;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

import java.util.Arrays;
import java.util.logging.Logger;

public class CallBack {

    public static Logger log = Logger.getLogger(CallBack.class.getSimpleName());

    public interface CLibrary extends Library {

        public interface NotificationListener extends Callback {
            void invoke(Pointer val, int lenth);
        }

        public static class NotificationListenerImpl implements NotificationListener {
            @Override
            public void invoke(Pointer val, int lenth) {
                log.info("returned byte array, size: " + lenth);
                log.info("java mehtod, callback: " + Arrays.toString(val.getByteArray(0, lenth)));
            }
        }

        public int callbackTriger(NotificationListener callback);
    }


    static public void main(String argv[]) {

        CLibrary clib = (CLibrary) Native.loadLibrary("/Users/kimfk567/Documents/IntelliSave/FreeRDP-Mac2/client/Mac/cli/MacFreeRDP.app/Contents/MacOS/MacFreeRDP", CLibrary.class);

        // instantiate a callback wrapper instance
        CLibrary.NotificationListenerImpl callbackImpl = new CLibrary.NotificationListenerImpl();

        // pass the callback wrapper to the C library
        int a = clib.callbackTriger(callbackImpl);
        System.out.println("a??"+a);


    }
}
