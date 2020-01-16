package com.jjonami.retrofitsample

data class Contributors (
    var login: String? = null,
    var id: Int? = null,
    var nodeId: String? = null,
    var avatarUrl: String? = null,
    var gravatarId: String? = null,
    var url: String? = null,
    var htmlUrl: String? = null,
    var followersUrl: String? = null,
    var followingUrl: String? = null,
    var gistsUrl: String? = null,
    var starredUrl: String? = null,
    var subscriptionsUrl: String? = null,
    var organizationsUrl: String? = null,
    var reposUrl: String? = null,
    var eventsUrl: String? = null,
    var receivedEventsUrl: String? = null,
    var type: String? = null,
    var siteAdmin: Boolean? = null,
    var contributions: Int? = null
)