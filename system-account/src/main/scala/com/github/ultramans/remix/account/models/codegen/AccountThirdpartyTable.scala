package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountThirdparty
trait AccountThirdpartyTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountThirdparty
   *  @param userId Database column user_id SqlType(int8), PrimaryKey
   *  @param wxToken Database column wx_token SqlType(varchar), Length(255,true) */
  case class AccountThirdpartyRow(userId: Long, wxToken: String)
  /** GetResult implicit for fetching AccountThirdpartyRow objects using plain SQL queries */
  implicit def GetResultAccountThirdpartyRow(implicit e0: GR[Long], e1: GR[String]): GR[AccountThirdpartyRow] = GR{
    prs => import prs._
    AccountThirdpartyRow.tupled((<<[Long], <<[String]))
  }
  /** Table description of table account_thirdparty. Objects of this class serve as prototypes for rows in queries. */
  class AccountThirdparty(_tableTag: Tag) extends profile.api.Table[AccountThirdpartyRow](_tableTag, "account_thirdparty") {
    def * = (userId, wxToken) <> (AccountThirdpartyRow.tupled, AccountThirdpartyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), Rep.Some(wxToken))).shaped.<>({r=>import r._; _1.map(_=> AccountThirdpartyRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(int8), PrimaryKey */
    val userId: Rep[Long] = column[Long]("user_id", O.PrimaryKey)
    /** Database column wx_token SqlType(varchar), Length(255,true) */
    val wxToken: Rep[String] = column[String]("wx_token", O.Length(255,varying=true))

    /** Uniqueness Index over (wxToken) (database name account_thirdparty_wx_token_uindex) */
    val index1 = index("account_thirdparty_wx_token_uindex", wxToken, unique=true)
  }
  /** Collection-like TableQuery object for table AccountThirdparty */
  lazy val AccountThirdparty = new TableQuery(tag => new AccountThirdparty(tag))
}
