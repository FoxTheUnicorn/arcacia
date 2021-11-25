<h2>Enemy:</h2>
[<code>Enemy</code>](Enemy.java): stores the Enemy class and all Attributes and Methods

<h3>Attributes:</h3>



<h3>Methods:</h3>
[<code>Enemy(Location currentlocation)</code>] : Konstruktor<br>
[<code>Enemy(int x, int y)</code>] : Konstruktor<br>
[<code>boolean: bewegeX</code>] : move horizontally if possible<br>
[<code>boolean: bewegeY</code>] : move vertically if possible<br>
[<code>boolean: siehtSpieler</code>] : returns true if Enemy sees Player<br>
[<code>void: geheRandom</code>] : Enemy moves randomly on the map<br>
[<code>void: geheSchritt</code>] : moves 1 Step<br>
[<code>void: setzeAufStart</code>] : resets Enemy on startlocation<br>
[<code>boolean: spieler_collision(spieler_location,enemy_location)</code>] : returns true if Enemy collides with Player<br>
[<code>void: bewegeAufPosition</code>] : moves to the location where the Player was last seen<br>
