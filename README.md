# HAXTEST

A hacked client-- I mean utility mod for Minecraft made by your beloved Ornithopter747!

## How to use

### Install it

You can either build it yourself:

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

Or just download the latest realease. Doing so however will probably not give you the cutting edge version. I keep the master branch always functional btw.

### Use it

This client does not have a mod menu (yet), everything is a key-bind. Check Options > Controls > Key Binds in Minecraft.
They're at the bottom usually.

## Reference guide

To activate a mod set up its keybind and press it to toggle it.

### AimBot

Locks view on the closest player if they're within 7 blocks

### AntiAFK

Moves the player left and right small amounts, never tested but can probably cheat vanilla afk kicking.

### ChestESP

Draws a square outline around the below tile entities:
- Chest
- Dropper
- EnderChest
- TrappedChest
- Dispenser
- Hopper
- Banner
- Furnace
- BrewingStand
- ShulkerBox
- Banner
- Smoker
- BlastFurnace
- Beacon
- MobSpawner
- EnchantingTable

### Fly

Moves the player up if spacebar is pressed, down if shift is pressed. NoFallDamage can cause damage mid-air if active.
`¯\_(ツ)_/¯`

### KillAura

Attacks nearby players without needing to look at them. Gets caught/blocked by competent anticheats.

### NoFallDamage

Negates fall damage by sending a packet claiming to be on the floor. Acts really sketchy with big heights and especially other hacks-- i mean mods.

### PlayerESP

Draws a square outline around all players within render distance

### Speed

Multiplies the player's horizontal speed by 7 when moving.

## Documentation

Check [docu.md](docu.md)

## TODO

In order of importance:
- [x] Speed
- [x] Anti-AFK (not 2b2t compatible)
- [x] Aim-bot (closest player)
- [x] Chest ESP
- [x] Player ESP
- [x] KillAura (hardcoded sword timings) (closest player)
- [ ] Auto-clicker (perfect 1.9+ pvp timings)
- [x] HUD Mod List
- [x] HUD coords thingy
- [ ] Settings menu
- [ ] New chunks
- [ ] Baritone integration // really needed?
- [ ] Trajectories
- [ ] Breadcrumbs