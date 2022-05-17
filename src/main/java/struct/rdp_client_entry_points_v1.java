package struct;

import com.sun.jna.*;
import struct.rdp_client_entry_points_v1_library.*;


@com.sun.jna.Structure.FieldOrder({ "Size", "Version", "settings", "GlobalInit", "GlobalUninit", "ContextSize", "ClientNew", "ClientFree", "ClientStart", "ClientStop" })
    public  class rdp_client_entry_points_v1 extends Structure {
     public int Size;
        public int Version;
        public struct.rdp_client_entry_points_v1_library.rdpSettings settings;
        public pRdpGlobalInit GlobalInit;
        public pRdpGlobalUninit GlobalUninit;
        public int ContextSize;
        public pRdpClientNew ClientNew;
        public pRdpClientFree ClientFree;
        public pRdpClientStart ClientStart;
        public pRdpClientStop ClientStop;
        public rdp_client_entry_points_v1() {
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



