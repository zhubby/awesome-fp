package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountCertificate
trait AccountCertificateTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountCertificate
   *  @param userId Database column user_id SqlType(int8), PrimaryKey
   *  @param realname Database column realname SqlType(varchar), Length(50,true)
   *  @param identityCode Database column identity_code SqlType(varchar), Length(18,true)
   *  @param identityPositiveImg Database column identity_positive_img SqlType(varchar), Length(255,true)
   *  @param identityNegativeImg Database column identity_negative_img SqlType(varchar), Length(255,true)
   *  @param createTime Database column create_time SqlType(int4), Default(0)
   *  @param updateTime Database column update_time SqlType(int4), Default(0) */
  case class AccountCertificateRow(userId: Long, realname: String, identityCode: String, identityPositiveImg: String, identityNegativeImg: String, createTime: Int = 0, updateTime: Int = 0)
  /** GetResult implicit for fetching AccountCertificateRow objects using plain SQL queries */
  implicit def GetResultAccountCertificateRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int]): GR[AccountCertificateRow] = GR{
    prs => import prs._
    AccountCertificateRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[Int], <<[Int]))
  }
  /** Table description of table account_certificate. Objects of this class serve as prototypes for rows in queries. */
  class AccountCertificate(_tableTag: Tag) extends profile.api.Table[AccountCertificateRow](_tableTag, "account_certificate") {
    def * = (userId, realname, identityCode, identityPositiveImg, identityNegativeImg, createTime, updateTime) <> (AccountCertificateRow.tupled, AccountCertificateRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), Rep.Some(realname), Rep.Some(identityCode), Rep.Some(identityPositiveImg), Rep.Some(identityNegativeImg), Rep.Some(createTime), Rep.Some(updateTime))).shaped.<>({r=>import r._; _1.map(_=> AccountCertificateRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(int8), PrimaryKey */
    val userId: Rep[Long] = column[Long]("user_id", O.PrimaryKey)
    /** Database column realname SqlType(varchar), Length(50,true) */
    val realname: Rep[String] = column[String]("realname", O.Length(50,varying=true))
    /** Database column identity_code SqlType(varchar), Length(18,true) */
    val identityCode: Rep[String] = column[String]("identity_code", O.Length(18,varying=true))
    /** Database column identity_positive_img SqlType(varchar), Length(255,true) */
    val identityPositiveImg: Rep[String] = column[String]("identity_positive_img", O.Length(255,varying=true))
    /** Database column identity_negative_img SqlType(varchar), Length(255,true) */
    val identityNegativeImg: Rep[String] = column[String]("identity_negative_img", O.Length(255,varying=true))
    /** Database column create_time SqlType(int4), Default(0) */
    val createTime: Rep[Int] = column[Int]("create_time", O.Default(0))
    /** Database column update_time SqlType(int4), Default(0) */
    val updateTime: Rep[Int] = column[Int]("update_time", O.Default(0))

    /** Uniqueness Index over (identityCode) (database name account_certificate_identity_code_uindex) */
    val index1 = index("account_certificate_identity_code_uindex", identityCode, unique=true)
  }
  /** Collection-like TableQuery object for table AccountCertificate */
  lazy val AccountCertificate = new TableQuery(tag => new AccountCertificate(tag))
}
