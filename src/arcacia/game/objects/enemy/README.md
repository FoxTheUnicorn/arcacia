<h2>Enemy:</h2>
[<code>Enemy</code>](Enemy.java): stores the Enemy class and all Attributes and Methods

<h3>Attributes:</h3>

[<code>Location: start</code>] : starting Location of Enemy Object<br>
[<code>Location: player</code>] : Location of the Player<br>
[<code>Location: last_seen</code>] : last seen Location of the Player<br>
[<code>GameObject: objectOnPosition</code>] : ???<br>
[<code>boolean: stopwatchOn</code>] : if the Player has the Item Stopwatch and uses it<br>
[<code>int: countdown</code>] : countdown for a short period of time <br>
[<code>static final int: maxFollow</code>] : (10) max. times the last_seen location of the Player is targeted<br>
[<code>static final int: maxVisibility</code>] : (10) max. range of blocks the Enemy sees<br>

<h3>Methods:</h3>

[<code>Enemy(Location currentlocation)</code>] : Konstruktor for starting Location of Enemy Object<br>
[<code>Enemy(int x, int y)</code>] : Konstruktor for starting Location of Enemy Object (x and y Achse)<br>
[<code>void: setStopwatch(boolean isOn)</code>] : setter for stopwatchOn and if true Enemy can't move<br>
[<code>Gameobject: getObjectOnPosition</code>] : getter for objectOnPoition<br>
[<code>boolean: moveX</code>] : move horizontally if possible<br>
[<code>boolean: moveY</code>] : move vertically if possible<br>
[<code>boolean: seePlayer</code>] : returns true if Enemy sees the Player<br>
[<code>void: moveRandom</code>] : Enemy moves randomly in any direction on the map<br>
[<code>void: movement</code>] : overall the movement of the Enemy<br>
[<code>void: reset</code>] : resets Enemy on startlocation<br>
[<code>boolean: spieler_collision(spieler_location,enemy_location)</code>] : returns true if Enemy collides with Player<br>
[<code>void: move_to_Position</code>] : moves to the location where the Player was last seen<br>
