# HAXTEST

Shitty ornithopter747 homemade hacked client for Minecraft.

## TODO

In order of importance:
- [x] Speed
- [x] Anti-AFK (not 2b2t compatible)
- [x] Aim-bot (closest player)
- [x] Chest ESP
- [x] Player ESP
- [ ] Auto-clicker (perfect 1.9+ pvp timings)
- [ ] New chunks
- [ ] Baritone integration
- [ ] Trajectories
- [ ] Breadcrumbs

## How to use

### Install

- Clone the repository
- Change dir into it
- run `./gradlew build` to build it with gradle
- The mod can be found in `build/libs/haxtest-<version>.jar`. Add it to your `mods` folder. It requires fabric and
  the fabric API.

```bash
git clone https:github.com/ornitongithub/haxtest
cd haxtest
./gradlew build
```

### Use it

This client does not have a mod menu (yet), everything is a key-bind. Check Options > Controls > Key Binds in Minecraft.
They're at the bottom usually.

## Documentation

java/ornit.haxtest/client is where all the good stuff happens.

HaxtestClient.java is the "entry point" for the client. It defines keybinds, does the needed rendering,
and calls the necessary modules.

modules/ contains all the modules (hacks). Each module has three parts:
- Module.active (bool)
- Module.Toggle() (toggles module.active)
- Module.Run() (runs the module, once) (HaxtestClient.java runs Module.Run() each tick if Module.active is true)

render/ contains a bunch of functions for rendering.

For even more info check the code lol
