package com.github.ultramans.remix.account.models.codegen
// AUTO-GENERATED Slick data model for table Account
trait AccountTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table Account
   *  @param userId Database column user_id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param phone Database column phone SqlType(varchar), Length(11,true), Default()
   *  @param password Database column password SqlType(varchar), Length(50,true), Default()
   *  @param nickname Database column nickname SqlType(varchar), Length(255,true), Default()
   *  @param createTime Database column create_time SqlType(int4), Default(0)
   *  @param updateTime Database column update_time SqlType(int4), Default(0)
   *  @param sex Database column sex SqlType(bool), Default(None)
   *  @param lastLoginIp Database column last_login_ip SqlType(inet), Length(2147483647,false)
   *  @param lastLoginTime Database column last_login_time SqlType(int4), Default(0)
   *  @param loginNum Database column login_num SqlType(int4), Default(0)
   *  @param marry Database column marry SqlType(bool), Default(None)
   *  @param birthday Database column birthday SqlType(date), Default(None)
   *  @param registerIp Database column register_ip SqlType(inet), Length(2147483647,false)
   *  @param registerTime Database column register_time SqlType(int4), Default(0)
   *  @param updateNum Database column update_num SqlType(int4), Default(0)
   *  @param headImg Database column head_img SqlType(varchar), Length(255,true), Default()
   *  @param channel Database column channel SqlType(int4), Default(0)
   *  @param inviter Database column inviter SqlType(int4), Default(None)
   *  @param certStatus Database column cert_status SqlType(int4), Default(0)
   *  @param status Database column status SqlType(int4), Default(0) */
  case class AccountRow(userId: Long, phone: String = "", password: String = "", nickname: String = "", createTime: Int = 0, updateTime: Int = 0, sex: Option[Boolean] = None, lastLoginIp: String, lastLoginTime: Int = 0, loginNum: Int = 0, marry: Option[Boolean] = None, birthday: Option[java.sql.Date] = None, registerIp: String, registerTime: Int = 0, updateNum: Int = 0, headImg: String = "", channel: Int = 0, inviter: Option[Int] = None, certStatus: Int = 0, status: Int = 0)
  /** GetResult implicit for fetching AccountRow objects using plain SQL queries */
  implicit def GetResultAccountRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[Option[Boolean]], e4: GR[Option[java.sql.Date]], e5: GR[Option[Int]]): GR[AccountRow] = GR{
    prs => import prs._
    AccountRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[Int], <<[Int], <<?[Boolean], <<[String], <<[Int], <<[Int], <<?[Boolean], <<?[java.sql.Date], <<[String], <<[Int], <<[Int], <<[String], <<[Int], <<?[Int], <<[Int], <<[Int]))
  }
  /** Table description of table account. Objects of this class serve as prototypes for rows in queries. */
  class Account(_tableTag: Tag) extends profile.api.Table[AccountRow](_tableTag, "account") {
    def * = (userId, phone, password, nickname, createTime, updateTime, sex, lastLoginIp, lastLoginTime, loginNum, marry, birthday, registerIp, registerTime, updateNum, headImg, channel, inviter, certStatus, status) <> (AccountRow.tupled, AccountRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), Rep.Some(phone), Rep.Some(password), Rep.Some(nickname), Rep.Some(createTime), Rep.Some(updateTime), sex, Rep.Some(lastLoginIp), Rep.Some(lastLoginTime), Rep.Some(loginNum), marry, birthday, Rep.Some(registerIp), Rep.Some(registerTime), Rep.Some(updateNum), Rep.Some(headImg), Rep.Some(channel), inviter, Rep.Some(certStatus), Rep.Some(status))).shaped.<>({r=>import r._; _1.map(_=> AccountRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8.get, _9.get, _10.get, _11, _12, _13.get, _14.get, _15.get, _16.get, _17.get, _18, _19.get, _20.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(bigserial), AutoInc, PrimaryKey */
    val userId: Rep[Long] = column[Long]("user_id", O.AutoInc, O.PrimaryKey)
    /** Database column phone SqlType(varchar), Length(11,true), Default() */
    val phone: Rep[String] = column[String]("phone", O.Length(11,varying=true), O.Default(""))
    /** Database column password SqlType(varchar), Length(50,true), Default() */
    val password: Rep[String] = column[String]("password", O.Length(50,varying=true), O.Default(""))
    /** Database column nickname SqlType(varchar), Length(255,true), Default() */
    val nickname: Rep[String] = column[String]("nickname", O.Length(255,varying=true), O.Default(""))
    /** Database column create_time SqlType(int4), Default(0) */
    val createTime: Rep[Int] = column[Int]("create_time", O.Default(0))
    /** Database column update_time SqlType(int4), Default(0) */
    val updateTime: Rep[Int] = column[Int]("update_time", O.Default(0))
    /** Database column sex SqlType(bool), Default(None) */
    val sex: Rep[Option[Boolean]] = column[Option[Boolean]]("sex", O.Default(None))
    /** Database column last_login_ip SqlType(inet), Length(2147483647,false) */
    val lastLoginIp: Rep[String] = column[String]("last_login_ip", O.Length(2147483647,varying=false))
    /** Database column last_login_time SqlType(int4), Default(0) */
    val lastLoginTime: Rep[Int] = column[Int]("last_login_time", O.Default(0))
    /** Database column login_num SqlType(int4), Default(0) */
    val loginNum: Rep[Int] = column[Int]("login_num", O.Default(0))
    /** Database column marry SqlType(bool), Default(None) */
    val marry: Rep[Option[Boolean]] = column[Option[Boolean]]("marry", O.Default(None))
    /** Database column birthday SqlType(date), Default(None) */
    val birthday: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("birthday", O.Default(None))
    /** Database column register_ip SqlType(inet), Length(2147483647,false) */
    val registerIp: Rep[String] = column[String]("register_ip", O.Length(2147483647,varying=false))
    /** Database column register_time SqlType(int4), Default(0) */
    val registerTime: Rep[Int] = column[Int]("register_time", O.Default(0))
    /** Database column update_num SqlType(int4), Default(0) */
    val updateNum: Rep[Int] = column[Int]("update_num", O.Default(0))
    /** Database column head_img SqlType(varchar), Length(255,true), Default() */
    val headImg: Rep[String] = column[String]("head_img", O.Length(255,varying=true), O.Default(""))
    /** Database column channel SqlType(int4), Default(0) */
    val channel: Rep[Int] = column[Int]("channel", O.Default(0))
    /** Database column inviter SqlType(int4), Default(None) */
    val inviter: Rep[Option[Int]] = column[Option[Int]]("inviter", O.Default(None))
    /** Database column cert_status SqlType(int4), Default(0) */
    val certStatus: Rep[Int] = column[Int]("cert_status", O.Default(0))
    /** Database column status SqlType(int4), Default(0) */
    val status: Rep[Int] = column[Int]("status", O.Default(0))

    /** Uniqueness Index over (phone) (database name account_phone_uindex) */
    val index1 = index("account_phone_uindex", phone, unique=true)
  }
  /** Collection-like TableQuery object for table Account */
  lazy val Account = new TableQuery(tag => new Account(tag))
}
