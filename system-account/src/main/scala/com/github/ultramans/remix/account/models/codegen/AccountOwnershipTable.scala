package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountOwnership
trait AccountOwnershipTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountOwnership
   *  @param osId Database column os_id SqlType(serial), AutoInc
   *  @param project Database column project SqlType(varchar), Length(50,true)
   *  @param version Database column version SqlType(varchar), Length(50,true)
   *  @param domain Database column domain SqlType(varchar), Length(255,true)
   *  @param path Database column path SqlType(varchar), Length(255,true)
   *  @param osName Database column os_name SqlType(varchar), Length(50,true)
   *  @param ajaxAble Database column ajax_able SqlType(bool), Default(false)
   *  @param originAble Database column origin_able SqlType(bool), Default(false)
   *  @param status Database column status SqlType(bool), Default(true)
   *  @param ip Database column ip SqlType(inet), Length(2147483647,false)
   *  @param createTime Database column create_time SqlType(int4), Default(0)
   *  @param updateTime Database column update_time SqlType(int4), Default(0) */
  case class AccountOwnershipRow(osId: Int, project: String, version: String, domain: String, path: String, osName: String, ajaxAble: Boolean = false, originAble: Boolean = false, status: Boolean = true, ip: String, createTime: Int = 0, updateTime: Int = 0)
  /** GetResult implicit for fetching AccountOwnershipRow objects using plain SQL queries */
  implicit def GetResultAccountOwnershipRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[AccountOwnershipRow] = GR{
    prs => import prs._
    AccountOwnershipRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Boolean], <<[Boolean], <<[Boolean], <<[String], <<[Int], <<[Int]))
  }
  /** Table description of table account_ownership. Objects of this class serve as prototypes for rows in queries. */
  class AccountOwnership(_tableTag: Tag) extends profile.api.Table[AccountOwnershipRow](_tableTag, "account_ownership") {
    def * = (osId, project, version, domain, path, osName, ajaxAble, originAble, status, ip, createTime, updateTime) <> (AccountOwnershipRow.tupled, AccountOwnershipRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(osId), Rep.Some(project), Rep.Some(version), Rep.Some(domain), Rep.Some(path), Rep.Some(osName), Rep.Some(ajaxAble), Rep.Some(originAble), Rep.Some(status), Rep.Some(ip), Rep.Some(createTime), Rep.Some(updateTime))).shaped.<>({r=>import r._; _1.map(_=> AccountOwnershipRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column os_id SqlType(serial), AutoInc */
    val osId: Rep[Int] = column[Int]("os_id", O.AutoInc)
    /** Database column project SqlType(varchar), Length(50,true) */
    val project: Rep[String] = column[String]("project", O.Length(50,varying=true))
    /** Database column version SqlType(varchar), Length(50,true) */
    val version: Rep[String] = column[String]("version", O.Length(50,varying=true))
    /** Database column domain SqlType(varchar), Length(255,true) */
    val domain: Rep[String] = column[String]("domain", O.Length(255,varying=true))
    /** Database column path SqlType(varchar), Length(255,true) */
    val path: Rep[String] = column[String]("path", O.Length(255,varying=true))
    /** Database column os_name SqlType(varchar), Length(50,true) */
    val osName: Rep[String] = column[String]("os_name", O.Length(50,varying=true))
    /** Database column ajax_able SqlType(bool), Default(false) */
    val ajaxAble: Rep[Boolean] = column[Boolean]("ajax_able", O.Default(false))
    /** Database column origin_able SqlType(bool), Default(false) */
    val originAble: Rep[Boolean] = column[Boolean]("origin_able", O.Default(false))
    /** Database column status SqlType(bool), Default(true) */
    val status: Rep[Boolean] = column[Boolean]("status", O.Default(true))
    /** Database column ip SqlType(inet), Length(2147483647,false) */
    val ip: Rep[String] = column[String]("ip", O.Length(2147483647,varying=false))
    /** Database column create_time SqlType(int4), Default(0) */
    val createTime: Rep[Int] = column[Int]("create_time", O.Default(0))
    /** Database column update_time SqlType(int4), Default(0) */
    val updateTime: Rep[Int] = column[Int]("update_time", O.Default(0))
  }
  /** Collection-like TableQuery object for table AccountOwnership */
  lazy val AccountOwnership = new TableQuery(tag => new AccountOwnership(tag))
}
