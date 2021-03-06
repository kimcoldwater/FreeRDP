package struct;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
import struct.entryPoint_library.*;

/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
@Structure.FieldOrder({"Size", "Version", "settings", "GlobalInit", "GlobalUninit", "ContextSize", "ClientNew", "ClientFree", "ClientStart", "ClientStop", "testNum"})
public class entryPoint extends Structure {
    public int Size;
    public int Version;
    public rdpSettings settings;
    public pRdpGlobalInit GlobalInit;
    public pRdpGlobalUninit GlobalUninit;
    public int ContextSize;
    public pRdpClientNew ClientNew;
    public pRdpClientFree ClientFree;
    public pRdpClientStart ClientStart;
    public pRdpClientStop ClientStop;
    public int testNum;
    public entryPoint() {
        super();
    }

    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected rdp_client_entry_points_v1 newInstance() { return new rdp_client_entry_points_v1(); }
    public static class ByReference extends rdp_client_entry_points_v1 implements Structure.ByReference {

    };
    public static class ByValue extends rdp_client_entry_points_v1 implements Structure.ByValue {

    };
}
