package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountBehaviorLog
trait AccountBehaviorLogTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountBehaviorLog
   *  @param id Database column id SqlType(int8), PrimaryKey
   *  @param userId Database column user_id SqlType(int8) */
  case class AccountBehaviorLogRow(id: Long, userId: Long)
  /** GetResult implicit for fetching AccountBehaviorLogRow objects using plain SQL queries */
  implicit def GetResultAccountBehaviorLogRow(implicit e0: GR[Long]): GR[AccountBehaviorLogRow] = GR{
    prs => import prs._
    AccountBehaviorLogRow.tupled((<<[Long], <<[Long]))
  }
  /** Table description of table account_behavior_log. Objects of this class serve as prototypes for rows in queries. */
  class AccountBehaviorLog(_tableTag: Tag) extends profile.api.Table[AccountBehaviorLogRow](_tableTag, "account_behavior_log") {
    def * = (id, userId) <> (AccountBehaviorLogRow.tupled, AccountBehaviorLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(userId))).shaped.<>({r=>import r._; _1.map(_=> AccountBehaviorLogRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int8), PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.PrimaryKey)
    /** Database column user_id SqlType(int8) */
    val userId: Rep[Long] = column[Long]("user_id")
  }
  /** Collection-like TableQuery object for table AccountBehaviorLog */
  lazy val AccountBehaviorLog = new TableQuery(tag => new AccountBehaviorLog(tag))
}
