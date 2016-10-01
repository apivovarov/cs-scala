package org.x4444.csscala.tree

/**
  * ListToTree
  */

case class Comment(id: Int, parentId: Int, text: String)

case class Node(comment: Comment, children: List[Node])

object ListToTree {

  def main(args: Array[String]): Unit = {
    val comments = List(
      Comment(11, 0, "11"),
      Comment(12, 0, "12"),
      Comment(13, 0, "13"),

      Comment(111, 11, "111"),
      Comment(112, 11, "112"),
      Comment(113, 11, "113"),
      Comment(114, 11, "114"),

      Comment(121, 12, "121"),
      Comment(122, 12, "122"),
      Comment(123, 12, "123"),
      Comment(124, 12, "124"),

      Comment(1211, 121, "1211"),
      Comment(1212, 121, "1212"),
      Comment(1221, 122, "1221"),
      Comment(1222, 122, "1222")
    )

    val tree = toTree(comments)
    tree.foreach(println)
  }

  /**
    *
    * @param l List of comments
    * @return List of root Nodes
    */
  def toTree(l: List[Comment]): List[Node] = {

    val (roots, nonRoots) = l.partition(c => c.parentId == 0)

    val dic = nonRoots.groupBy(c => c.parentId)

    roots.map(c => Node(c, getChildren(c, dic)))
  }

  def getChildren(c: Comment, dic: Map[Int, List[Comment]]): List[Node] = {
    dic.get(c.id).map(_.map(c2 => Node(c2, getChildren(c2, dic)))).getOrElse(Nil)
  }
}
