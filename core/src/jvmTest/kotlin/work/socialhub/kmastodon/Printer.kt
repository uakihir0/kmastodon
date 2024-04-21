package work.socialhub.kmastodon

import work.socialhub.kmastodon.entity.Account
import work.socialhub.kmastodon.entity.Notification
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

    fun AbstractTest.dump(
        notification: Notification,
        sp: String
    ) {
        println("${sp}=== Notification ===")
        println("${sp}ID          > ${notification.id}")
        println("${sp}Type        > ${notification.type}")
        println("${sp}CreatedAt   > ${notification.createdAt}")
        println("")
    }

    fun AbstractTest.dumpAccounts(
        data: Array<Account>,
        sp: String = ""
    ) {
        for (account in data) dump(account, sp)
    }

    fun AbstractTest.dumpStatuses(
        data: Array<Status>,
        sp: String = ""
    ) {
        for (status in data) dump(status, sp)
    }

    fun AbstractTest.dumpNotifications(
        data: Array<Notification>,
        sp: String = ""
    ) {
        for (notification in data) dump(notification, sp)
    }
}
