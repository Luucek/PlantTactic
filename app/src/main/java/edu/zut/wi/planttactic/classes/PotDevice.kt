package edu.zut.wi.planttactic.classes


class PotDevice() {

    var id: String = ""
    var name: String = ""
    var imageID: Int = 0

    constructor(name: String, imageID: Int) : this() {
        this.name = name
        this.imageID = imageID
    }

}