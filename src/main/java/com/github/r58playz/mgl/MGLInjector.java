package com.github.r58playz.mgl;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

public class MGLInjector implements PreLaunchEntrypoint {

    @Override
    public void onPreLaunch() {
        // The earliest possible entrypoint, which is called just before the game launches.
        // Use with caution to not interfere with the game's initialization.
        // Uses the type PreLaunchEntryPoint and will call onPreLaunch.

        MGL.LOGGER.debug("mglmod: java.library.path is " + System.getProperty("java.library.path"));

        // Copy over dylibs to temp dir.
        try {
            // giant hack fix please
            // more :pofat: stuffs
            File mglDylibDir = new File(System.getProperty("java.library.path"));
            Files.createDirectories(mglDylibDir.toPath());
            Path glfwDylib = mglDylibDir.toPath().resolve("libGLFW.dylib");
            Path mglDylib = mglDylibDir.toPath().resolve("libMGL.dylib");
            MGL.LOGGER.debug("mglmod: glfwDylib is " + glfwDylib.toAbsolutePath().toString());
            MGL.LOGGER.debug("mglmod: mglDylib is " + mglDylib.toAbsolutePath().toString());

            try {
                FileUtils.deleteDirectory(new File(mglDylibDir.toPath().toAbsolutePath() + "/macos/arm64/org/lwjgl/glfw"));
            } catch (IOException e) {
                MGL.LOGGER.warn("mglmod: failed to delete macos arm64 glfw natives dir");
            }

            try {
                FileUtils.deleteDirectory(new File(mglDylibDir.toPath().toAbsolutePath() + "/macos/x86_64/org/lwjgl/glfw"));
            } catch (IOException e) {
                MGL.LOGGER.warn("mglmod: failed to delete macos x86_64 glfw natives dir");
            }

            try (InputStream glfwStream = MGLInjector.class.getResourceAsStream("/assets/mglmod/natives/libGLFW.dylib")) {
                if (glfwStream != null) {
                    Files.copy(glfwStream, glfwDylib, StandardCopyOption.REPLACE_EXISTING);
                } else {
                    MGL.LOGGER.error("mglmod: GLFW dylib stream is null! Cannot copy dylib!");
                }
            }

            try (InputStream mglStream = MGLInjector.class.getResourceAsStream("/assets/mglmod/natives/libMGL.dylib")) {
                if (mglStream != null) {
                    Files.copy(mglStream, mglDylib, StandardCopyOption.REPLACE_EXISTING);
                } else {
                    MGL.LOGGER.error("mglmod: GLFW dylib stream is null! Cannot copy dylib!");
                }
            }

            System.setProperty("org.lwjgl.librarypath", String.valueOf(mglDylibDir.toPath().toAbsolutePath()));
            System.setProperty("org.lwjgl.glfw.libname", "libGLFW.dylib");
            System.setProperty("org.lwjgl.opengl.libname", "libMGL.dylib");
            MGL.LOGGER.debug("mglmod: MGL library path is " + mglDylibDir.toPath().toAbsolutePath());
        } catch (IOException e) {
            MGL.LOGGER.error("mglmod: Failed to inject MGL libs. Throwing exception.");
            MGLReporter.error("Failed to inject MGL libraries.");
            throw new RuntimeException(e);
        }
    }
}
