package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table AccountRole
trait AccountRoleTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table AccountRole
   *  @param roleId Database column role_id SqlType(serial), AutoInc, PrimaryKey
   *  @param roleIdent Database column role_ident SqlType(varchar), Length(50,true)
   *  @param createTime Database column create_time SqlType(int4), Default(0)
   *  @param updateTime Database column update_time SqlType(int4), Default(0)
   *  @param ownerships Database column ownerships SqlType(_int4), Length(10,false) */
  case class AccountRoleRow(roleId: Int, roleIdent: String, createTime: Int = 0, updateTime: Int = 0, ownerships: String)
  /** GetResult implicit for fetching AccountRoleRow objects using plain SQL queries */
  implicit def GetResultAccountRoleRow(implicit e0: GR[Int], e1: GR[String]): GR[AccountRoleRow] = GR{
    prs => import prs._
    AccountRoleRow.tupled((<<[Int], <<[String], <<[Int], <<[Int], <<[String]))
  }
  /** Table description of table account_role. Objects of this class serve as prototypes for rows in queries. */
  class AccountRole(_tableTag: Tag) extends profile.api.Table[AccountRoleRow](_tableTag, "account_role") {
    def * = (roleId, roleIdent, createTime, updateTime, ownerships) <> (AccountRoleRow.tupled, AccountRoleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(roleId), Rep.Some(roleIdent), Rep.Some(createTime), Rep.Some(updateTime), Rep.Some(ownerships))).shaped.<>({r=>import r._; _1.map(_=> AccountRoleRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column role_id SqlType(serial), AutoInc, PrimaryKey */
    val roleId: Rep[Int] = column[Int]("role_id", O.AutoInc, O.PrimaryKey)
    /** Database column role_ident SqlType(varchar), Length(50,true) */
    val roleIdent: Rep[String] = column[String]("role_ident", O.Length(50,varying=true))
    /** Database column create_time SqlType(int4), Default(0) */
    val createTime: Rep[Int] = column[Int]("create_time", O.Default(0))
    /** Database column update_time SqlType(int4), Default(0) */
    val updateTime: Rep[Int] = column[Int]("update_time", O.Default(0))
    /** Database column ownerships SqlType(_int4), Length(10,false) */
    val ownerships: Rep[String] = column[String]("ownerships", O.Length(10,varying=false))

    /** Uniqueness Index over (roleIdent) (database name account_role_role_ident_uindex) */
    val index1 = index("account_role_role_ident_uindex", roleIdent, unique=true)
  }
  /** Collection-like TableQuery object for table AccountRole */
  lazy val AccountRole = new TableQuery(tag => new AccountRole(tag))
}
