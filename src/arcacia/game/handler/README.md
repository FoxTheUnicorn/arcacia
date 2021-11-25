<h1>Handler</h1>
Here are all Handlers which give static methods for Objects
<h2>LevelHandler</h2>

[<code>LevelHandler</code>](LevelHandler.java): stores the Level and gives some useful Methods for the Objects

<h3>Attributes</h3>
[<code>int: level_width</code>](LevelHandler.java#L8): The constant width of each level.<br>
[<code>int: level_height</code>](LevelHandler.java#L9): The constant height of each level.<br>
[<code>GameObject: grid[][]</code>](LevelHandler.java#L10): The grid where the current Level is saved. All GameObjects for this level are stored here.<br>

<h3>Functions</h3>
[<code>boolean: isWall(Location location)</code>](LevelHandler.java#L16): Check if tile at location is solid/wall.<br>
[<code>GameObject: setObjectAt(Location location, GameObject object)</code>](LevelHandler.java#L20): Set tile at location to object. Returns the old tile. <br>
[<code>GameObject: getObjectAt(Location location)</code>](LevelHandler.java#L20): Get tile at location.
<h3>DebugFunctions:</h3>
[<code>void: debugInitGrid()</code>](LevelHandler.java#L26): Fills the grid with WallTiles.


