package work.socialhub.kmastodon

import work.socialhub.kmastodon.entity.Account

object Printer {

    fun AbstractTest.dump(account: Account) {

        println("=== Account ===")
        println("ID          > ${account.id}")
        println("Account     > ${account.account}")
        println("UserName    > ${account.userName}")
        println("DisplayName > ${account.displayName}")
        println("")
    }
}