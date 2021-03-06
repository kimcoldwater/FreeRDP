package struct;

import com.sun.jna.*;

/**
 * JNA Wrapper for library <b>rdp_context</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class rdp_client_entry_points_v1_library implements Library {
    static {
        Native.register("/Users/kimfk567/Documents/IntelliSave/FreeRDP-Mac2/client/Mac/cli/MacFreeRDP.app/Contents/MacOS/MacFreeRDP");
    }

    public static final String RDP_CLIENT_ENTRY_POINT_NAME = (String)"RdpClientEntry";
    public static final int RDP_CLIENT_INTERFACE_VERSION = (int)1;
    public interface pRdpGlobalInit extends Callback {
        boolean apply();
    };
    public interface pRdpGlobalUninit extends Callback {
        void apply();
    };
    public interface pRdpClientNew extends Callback {
        boolean apply(freerdp instance, rdpContext context);
    };
    public interface pRdpClientFree extends Callback {
        void apply(freerdp instance, rdpContext context);
    };
    public interface pRdpClientStart extends Callback {
        int apply(rdpContext context);
    };
    public interface pRdpClientStop extends Callback {
        int apply(rdpContext context);
    };
    public interface pRdpClientEntry extends Callback {
        int apply(RDP_CLIENT_ENTRY_POINTS pEntryPoints);
    };
    /** Pointer to unknown (opaque) type */
    public static class freerdp extends PointerType {
        public freerdp(Pointer address) {
            super(address);
        }
        public freerdp() {
            super();
        }
    };
    /** Pointer to unknown (opaque) type */
    public static class rdpContext extends PointerType {
        public rdpContext(Pointer address) {
            super(address);
        }
        public rdpContext() {
            super();
        }
    };
    /** Pointer to unknown (opaque) type */
    public static class rdpSettings extends PointerType {
        public rdpSettings(Pointer address) {
            super(address);
        }
        public rdpSettings() {
            super();
        }
    };
    /** Pointer to unknown (opaque) type */
    public static class RDP_CLIENT_ENTRY_POINTS extends PointerType {
        public RDP_CLIENT_ENTRY_POINTS(Pointer address) {
            super(address);
        }
        public RDP_CLIENT_ENTRY_POINTS() {
            super();
        }
    };
}
