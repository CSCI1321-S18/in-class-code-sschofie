package basics

import ADT.ArrayQueue

object BFS extends App{
  val maze = Array(
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
  
  val offsets = List((1, 0), (-1, 0), (0, 1), (0, -1))
      
  def bfs(maze: Array[Array[Int]], sx: Int, sy: Int,
      ex:Int, ey:Int):Int = {
    val queue = new ArrayQueue[(Int, Int, Int)]
    var visited = Set[(Int, Int)]()
    queue.enqueue((sx, sy, 0))
     visited += (sx -> sy)
    while(!queue.isEmpty){
      val(x, y, steps) = queue.dequeue()
     for((dx, dy) <- offsets){
       val (nx, ny) = (x + dx, y + dy)
       if(nx==ex && ny==ey) return steps+1
       if(nx>=0 && nx<maze.length && ny>=0 && ny<maze(x).length && maze(nx)(ny)==0 && !visited(nx -> ny)){
         queue.enqueue((nx, ny, steps+1))
       }
     }
    }
    -1 //do not return -1 on graphical game
  }
  println(bfs(maze, 0, 0, 9, 9))
}