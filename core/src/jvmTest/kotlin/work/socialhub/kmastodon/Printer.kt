package work.socialhub.kmastodon

import work.socialhub.kmastodon.entity.Account
import work.socialhub.kmastodon.entity.Status

object Printer {

    fun AbstractTest.dump(
        account: Account,
        sp: String = ""
    ) {
        println("${sp}=== Account ===")
        println("${sp}ID          > ${account.id}")
        println("${sp}Account     > ${account.account}")
        println("${sp}UserName    > ${account.userName}")
        println("${sp}DisplayName > ${account.displayName}")
        println("")
    }

    fun AbstractTest.dump(
        status: Status,
        sp: String = ""
    ) {
        println("${sp}=== Status ===")
        println("${sp}ID          > ${status.id}")
        println("${sp}Text        > ${status.text}")
        println("${sp}Content     > ${status.content}")
        println("${sp}URL         > ${status.url}")
        dump(status.account, "$sp| ")
        println("")
    }

    fun AbstractTest.dumpStatuses(
        data: Array<Status>,
        sp: String = ""
    ) {
        for (status in data) dump(status, sp)
    }
}