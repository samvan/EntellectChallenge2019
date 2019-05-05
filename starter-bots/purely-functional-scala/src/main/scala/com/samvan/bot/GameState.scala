package com.samvan.bot

object GameState {
  final case class Cell(x: Int, y: Int, `type`: String)

  type GameMap = Seq[Seq[Cell]]

  final case class State(
                          currentRound: Int,
                          maxRounds: Int,
                          mapSize: Int,
                          currentWormId: Int,
                          consecutiveDoNothingCount: Int,
                          myPlayer: Player,
                          opponents: Seq[Opponent],
                          map: GameMap)

  final case class Player(id: Int, score: Int, health: Int, worms: Seq[Worm])

  final case class Opponent(id: Int, score: Int, worms: Seq[OpponentWorm])

  final case class Worm(
                         id: Int,
                         health: Int,
                         position: Coord,
                         weapon: Weapon,
                         diggingRange: Int,
                         movementRange: Int)

  final case class OpponentWorm(
                                 id: Int,
                                 health: Int,
                                 position: Coord,
                                 diggingRange: Int,
                                 movementRange: Int)

  final case class Coord(x: Int, y: Int)

  final case class Weapon(damage: Int, range: Int)
}
