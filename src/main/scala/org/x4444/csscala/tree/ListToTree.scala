package org.x4444.csscala.tree

/**
  * ListToTree
  */

case class Comment(id: Int, parendId: Int, text: String)

case class Node(comment: Comment, children: List[Comment])

object ListToTree {

  /**
    *
    * @param l List of comments
    * @return List of root Nodes
    */
  def toTree(l: List[Comment]): List[Node] = {

/*    val (roots, nonRoots) = l. .splitAt  .splitAt(c => c.parendId != null)

    val dictionary = l.filter(c => c.parendId != null).groupBy(c => c.parendId)

    l.filter(c => c.parendId == null)*/
    ???
  }


}
