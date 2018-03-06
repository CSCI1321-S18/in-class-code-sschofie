package drmorio

case class PassableGrid(locsAndColors: Seq[(Int, Int, Entity.Colors.Value)],
    nextPill: Seq[(Int, Int, Entity.Colors.Value)])