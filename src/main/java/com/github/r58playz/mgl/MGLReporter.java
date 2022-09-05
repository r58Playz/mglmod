package com.github.r58playz.mgl;

import org.lwjgl.util.tinyfd.TinyFileDialogs;

public class MGLReporter {
    public static void issue(String errorMessage) {
        TinyFileDialogs.tinyfd_messageBox("MGL issue",
                "MGL may have caused an issue.\nProceed with caution as Minecraft may crash AT ANY MOMENT.\nMore info:\n"+errorMessage,
                "ok",
                "warning",
                true); // OK
    }
    public static void error(String errorMessage) {
        TinyFileDialogs.tinyfd_messageBox("MGL error",
                "MGL has crashed Minecraft.\nMore info:\n"+errorMessage,
                "ok",
                "error",
                true); // OK
    }

    public static void generic(String errorMessage, String severity) {
        TinyFileDialogs.tinyfd_messageBox("MGL "+severity,
                errorMessage,
                "ok",
                severity,
                true); //OK
    }
}
