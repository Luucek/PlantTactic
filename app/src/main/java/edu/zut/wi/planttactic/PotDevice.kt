package edu.zut.wi.planttactic


class PotDevice() {

    var id: Int = 0
    var name: String = ""
    var imageName: String = ""

    constructor(name: String, imageName: String) : this() {
        this.name = name
        this.imageName = imageName
    }

}