package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountCertificateLog
trait AccountCertificateLogTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountCertificateLog
   *  @param logId Database column log_id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int8) */
  case class AccountCertificateLogRow(logId: Long, userId: Long)
  /** GetResult implicit for fetching AccountCertificateLogRow objects using plain SQL queries */
  implicit def GetResultAccountCertificateLogRow(implicit e0: GR[Long]): GR[AccountCertificateLogRow] = GR{
    prs => import prs._
    AccountCertificateLogRow.tupled((<<[Long], <<[Long]))
  }
  /** Table description of table account_certificate_log. Objects of this class serve as prototypes for rows in queries. */
  class AccountCertificateLog(_tableTag: Tag) extends profile.api.Table[AccountCertificateLogRow](_tableTag, "account_certificate_log") {
    def * = (logId, userId) <> (AccountCertificateLogRow.tupled, AccountCertificateLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(logId), Rep.Some(userId))).shaped.<>({r=>import r._; _1.map(_=> AccountCertificateLogRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column log_id SqlType(bigserial), AutoInc, PrimaryKey */
    val logId: Rep[Long] = column[Long]("log_id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int8) */
    val userId: Rep[Long] = column[Long]("user_id")
  }
  /** Collection-like TableQuery object for table AccountCertificateLog */
  lazy val AccountCertificateLog = new TableQuery(tag => new AccountCertificateLog(tag))
}
