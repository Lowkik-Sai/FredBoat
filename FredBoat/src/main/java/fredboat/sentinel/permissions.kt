package fredboat.sentinel

enum class Permission(offset: Int, val uiName: String) : IPermissionSet {

    CREATE_INSTANT_INVITE(0, "Create Instant Invite"),
    KICK_MEMBERS(1, "Kick Members"),
    BAN_MEMBERS(2, "Ban Members"),
    ADMINISTRATOR(3, "Administrator"),
    MANAGE_CHANNEL(4, "Manage Channels"),
    MANAGE_SERVER(5, "Manage Server"),
    MESSAGE_ADD_REACTION(6, "Add Reactions"),
    VIEW_AUDIT_LOGS(7, "View Audit Logs"),

    // Applicable to all channel types
    VIEW_CHANNEL(10, "Read Text Channels & See Voice Channels"),

    // Text Permissions
    MESSAGE_READ(10, "Read Messages"),
    MESSAGE_WRITE(11, "Send Messages"),
    MESSAGE_TTS(12, "Send TTS Messages"),
    MESSAGE_MANAGE(13, "Manage Messages"),
    MESSAGE_EMBED_LINKS(14, "Embed Links"),
    MESSAGE_ATTACH_FILES(15, "Attach Files"),
    MESSAGE_HISTORY(16, "Read History"),
    MESSAGE_MENTION_EVERYONE(17, "Mention Everyone"),
    MESSAGE_EXT_EMOJI(18, "Use External Emojis"),

    // Voice Permissions
    VOICE_CONNECT(20, "Connect"),
    VOICE_SPEAK(21, "Speak"),
    VOICE_MUTE_OTHERS(22, "Mute Members"),
    VOICE_DEAF_OTHERS(23, "Deafen Members"),
    VOICE_MOVE_OTHERS(24, "Move Members"),
    VOICE_USE_VAD(25, "Use Voice Activity"),

    NICKNAME_CHANGE(26, "Change Nickname"),
    NICKNAME_MANAGE(27, "Manage Nicknames"),

    MANAGE_ROLES(28, "Manage Roles"),
    MANAGE_PERMISSIONS(28, "Manage Permissions"),
    MANAGE_WEBHOOKS(29, "Manage Webhooks"),
    MANAGE_EMOTES(30, "Manage Emojis");

    private val _raw: Long = 1L shl offset

    override fun raw() = _raw
    override fun plus(other: IPermissionSet) = PermissionSet(_raw or other.raw())
}

class PermissionSet(private val _raw: Long) : IPermissionSet {
    override fun raw(): Long = _raw
    override fun plus(other: IPermissionSet) = PermissionSet(_raw or other.raw())
}

interface IPermissionSet {
    fun raw(): Long
    operator fun plus(other: IPermissionSet): PermissionSet
}

val test = (Permission.MESSAGE_READ + Permission.MESSAGE_READ).raw() == Permission.MESSAGE_READ.raw()
