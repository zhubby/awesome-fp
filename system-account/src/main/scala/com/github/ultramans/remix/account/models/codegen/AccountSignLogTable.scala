package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountSignLog
trait AccountSignLogTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountSignLog
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int8)
   *  @param signTime Database column sign_time SqlType(int4), Default(0)
   *  @param continuous Database column continuous SqlType(bool), Default(false)
   *  @param gainCumulative Database column gain_cumulative SqlType(int4), Default(0) */
  case class AccountSignLogRow(id: Long, userId: Long, signTime: Int = 0, continuous: Boolean = false, gainCumulative: Int = 0)
  /** GetResult implicit for fetching AccountSignLogRow objects using plain SQL queries */
  implicit def GetResultAccountSignLogRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[Boolean]): GR[AccountSignLogRow] = GR{
    prs => import prs._
    AccountSignLogRow.tupled((<<[Long], <<[Long], <<[Int], <<[Boolean], <<[Int]))
  }
  /** Table description of table account_sign_log. Objects of this class serve as prototypes for rows in queries. */
  class AccountSignLog(_tableTag: Tag) extends profile.api.Table[AccountSignLogRow](_tableTag, "account_sign_log") {
    def * = (id, userId, signTime, continuous, gainCumulative) <> (AccountSignLogRow.tupled, AccountSignLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(userId), Rep.Some(signTime), Rep.Some(continuous), Rep.Some(gainCumulative))).shaped.<>({r=>import r._; _1.map(_=> AccountSignLogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int8) */
    val userId: Rep[Long] = column[Long]("user_id")
    /** Database column sign_time SqlType(int4), Default(0) */
    val signTime: Rep[Int] = column[Int]("sign_time", O.Default(0))
    /** Database column continuous SqlType(bool), Default(false) */
    val continuous: Rep[Boolean] = column[Boolean]("continuous", O.Default(false))
    /** Database column gain_cumulative SqlType(int4), Default(0) */
    val gainCumulative: Rep[Int] = column[Int]("gain_cumulative", O.Default(0))
  }
  /** Collection-like TableQuery object for table AccountSignLog */
  lazy val AccountSignLog = new TableQuery(tag => new AccountSignLog(tag))
}
