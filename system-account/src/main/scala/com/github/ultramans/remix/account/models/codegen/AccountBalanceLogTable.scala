package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountBalanceLog
trait AccountBalanceLogTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountBalanceLog
   *  @param id Database column id SqlType(int8), PrimaryKey
   *  @param userId Database column user_id SqlType(int8) */
  case class AccountBalanceLogRow(id: Long, userId: Long)
  /** GetResult implicit for fetching AccountBalanceLogRow objects using plain SQL queries */
  implicit def GetResultAccountBalanceLogRow(implicit e0: GR[Long]): GR[AccountBalanceLogRow] = GR{
    prs => import prs._
    AccountBalanceLogRow.tupled((<<[Long], <<[Long]))
  }
  /** Table description of table account_balance_log. Objects of this class serve as prototypes for rows in queries. */
  class AccountBalanceLog(_tableTag: Tag) extends profile.api.Table[AccountBalanceLogRow](_tableTag, "account_balance_log") {
    def * = (id, userId) <> (AccountBalanceLogRow.tupled, AccountBalanceLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(userId))).shaped.<>({r=>import r._; _1.map(_=> AccountBalanceLogRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int8), PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.PrimaryKey)
    /** Database column user_id SqlType(int8) */
    val userId: Rep[Long] = column[Long]("user_id")
  }
  /** Collection-like TableQuery object for table AccountBalanceLog */
  lazy val AccountBalanceLog = new TableQuery(tag => new AccountBalanceLog(tag))
}
