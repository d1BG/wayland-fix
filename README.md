# Wayland Fix for NeoForge

Minecraft running under Xwayland has always had its problems and there are multiple mods that aim to fix them, but all of them are for Fabric.

For this mod to work add `-Dorg.lwjgl.glfw.libname=/usr/lib/libglfw.so` in JVM arguments or the equivelent option in launchers like Prism - "Use System installation of GLFW" under the Workarounds section. 

Sometimes (mostly happening on Nvidia GPUs) the game still wont launch, you will need to set this env var: `__GL_THREADED_OPTIMIZATIONS = 0`

# What this mod fixes:
- Adds a minecraft icon instead of the normal wayland icon.
- Fixes key combinations: 'Ctrl+A', 'Ctrl+C', 'Ctrl+V' and 'Ctrl+X'

# Requirements:
- glfw>=3.4

## How to build?
- `git clone https://github.com/d1BG/wayland-fix`
- `cd wayland-fix`
- `./gradlew build`
- After building, the mod will be in `build/libs/waylandfix-version.jar`

## Special Thanks to:
- [WaylandFix](https://github.com/StackDoubleFlow/MCWaylandFix)
- [WayFix](https://github.com/not-coded/WayFix) - amazing mod, works on NeoForge, but not natively
