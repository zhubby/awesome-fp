package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountExp
trait AccountExpTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountExp
   *  @param userId Database column user_id SqlType(int8), PrimaryKey
   *  @param hobby Database column hobby SqlType(_int4), Length(10,false) */
  case class AccountExpRow(userId: Long, hobby: String)
  /** GetResult implicit for fetching AccountExpRow objects using plain SQL queries */
  implicit def GetResultAccountExpRow(implicit e0: GR[Long], e1: GR[String]): GR[AccountExpRow] = GR{
    prs => import prs._
    AccountExpRow.tupled((<<[Long], <<[String]))
  }
  /** Table description of table account_exp. Objects of this class serve as prototypes for rows in queries. */
  class AccountExp(_tableTag: Tag) extends profile.api.Table[AccountExpRow](_tableTag, "account_exp") {
    def * = (userId, hobby) <> (AccountExpRow.tupled, AccountExpRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), Rep.Some(hobby))).shaped.<>({r=>import r._; _1.map(_=> AccountExpRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(int8), PrimaryKey */
    val userId: Rep[Long] = column[Long]("user_id", O.PrimaryKey)
    /** Database column hobby SqlType(_int4), Length(10,false) */
    val hobby: Rep[String] = column[String]("hobby", O.Length(10,varying=false))
  }
  /** Collection-like TableQuery object for table AccountExp */
  lazy val AccountExp = new TableQuery(tag => new AccountExp(tag))
}
