install_name_tool -change ./libMGL.dylib @rpath/libMGL.dylib Debug/libGLFW.dylib
install_name_tool -add_rpath @loader_path Debug/libGLFW.dylib
codesign --force --deep --sign - Debug/libGLFW.dylib 
