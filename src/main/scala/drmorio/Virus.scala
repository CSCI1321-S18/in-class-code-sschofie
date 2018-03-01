/*package drmorio

class Virus(x: Int, y: Int) extends Block with Entity {
  //val _color = Block.Colors(util.Random.nextInt(3)) 
  def color: Block.Colors.Value = Block.Colors(util.Random.nextInt(3)) 

  def colors: List[Block.Colors.Value] = List(color)
  def locations: List[(Int, Int)] = List((x,y))

}*/

package drmorio

class Virus(x: Int, y: Int) extends Entity {
  val _color = Entity.Colors(util.Random.nextInt(3))

  def shape: DrMorioShape.Value = DrMorioShape.Circle

  def locsAndColors: List[(Int, Int, Entity.Colors.Value)] = List((x, y, _color))
  def move(dx: Int, dy: Int): Boolean = false
  
  def remove(x: Int, y: Int): Option[PillPiece] = None
}