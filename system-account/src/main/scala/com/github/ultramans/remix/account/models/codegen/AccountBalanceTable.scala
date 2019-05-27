package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountBalance
trait AccountBalanceTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountBalance
   *  @param userId Database column user_id SqlType(int8), PrimaryKey
   *  @param balance Database column balance SqlType(numeric)
   *  @param version Database column version SqlType(int4), Default(0)
   *  @param updateTime Database column update_time SqlType(int4), Default(0)
   *  @param createTime Database column create_time SqlType(int4), Default(0) */
  case class AccountBalanceRow(userId: Long, balance: scala.math.BigDecimal, version: Int = 0, updateTime: Int = 0, createTime: Int = 0)
  /** GetResult implicit for fetching AccountBalanceRow objects using plain SQL queries */
  implicit def GetResultAccountBalanceRow(implicit e0: GR[Long], e1: GR[scala.math.BigDecimal], e2: GR[Int]): GR[AccountBalanceRow] = GR{
    prs => import prs._
    AccountBalanceRow.tupled((<<[Long], <<[scala.math.BigDecimal], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table account_balance. Objects of this class serve as prototypes for rows in queries. */
  class AccountBalance(_tableTag: Tag) extends profile.api.Table[AccountBalanceRow](_tableTag, "account_balance") {
    def * = (userId, balance, version, updateTime, createTime) <> (AccountBalanceRow.tupled, AccountBalanceRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), Rep.Some(balance), Rep.Some(version), Rep.Some(updateTime), Rep.Some(createTime))).shaped.<>({r=>import r._; _1.map(_=> AccountBalanceRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(int8), PrimaryKey */
    val userId: Rep[Long] = column[Long]("user_id", O.PrimaryKey)
    /** Database column balance SqlType(numeric) */
    val balance: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("balance")
    /** Database column version SqlType(int4), Default(0) */
    val version: Rep[Int] = column[Int]("version", O.Default(0))
    /** Database column update_time SqlType(int4), Default(0) */
    val updateTime: Rep[Int] = column[Int]("update_time", O.Default(0))
    /** Database column create_time SqlType(int4), Default(0) */
    val createTime: Rep[Int] = column[Int]("create_time", O.Default(0))
  }
  /** Collection-like TableQuery object for table AccountBalance */
  lazy val AccountBalance = new TableQuery(tag => new AccountBalance(tag))
}
