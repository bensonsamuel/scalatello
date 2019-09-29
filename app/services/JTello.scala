package services

import java.io.IOException
import java.net.{DatagramPacket, DatagramSocket, InetAddress}


/** @author gnabit@gnamingo.de */
object JTello {
  val INSTANCE = new JTello
}

class JTello {
  private var ip: InetAddress = null
  private var port = 0
  private var s: DatagramSocket = null
  private var isImperial = false

  @throws[Exception]
  final def connect(): Unit = {
    this.connect("192.168.10.1", 8889)
  }

  @throws[Exception]
  final def connect(strIP: String, port: Int): Unit = {
    this.port = port
    ip = InetAddress.getByName(strIP)
    s = new DatagramSocket(port)
    s.connect(ip, port)
    sendCommand("command")
    System.out.println(s.getLocalPort)
    System.out.println(s.getLocalSocketAddress)
    System.out.println(s.getLocalAddress)
    System.out.println(s.getPort)
    System.out.println(s.getRemoteSocketAddress)
    System.out.println(s.getReuseAddress)
    System.out.println(s.getReceiveBufferSize)
    System.out.println(s.getSendBufferSize)
    System.out.println(s.getTrafficClass)
  }

  final private[services] def getIP = ip

  final private[services] def getPort = port

  final private[services] def getSocket = s

  final def isConnected: Boolean = {
    if (null == s) return false
    s.isConnected
  }

  def setImperial(isImperial: Boolean): Unit = {
    this.isImperial = isImperial
  }

  @throws[IOException]
  final def getBattery: String = sendCommand("battery?")

  @throws[IOException]
  final def getSpeed: String = sendCommand("speed?")

  @throws[IOException]
  final def getTime: String = sendCommand("time?")

  /**
    * whaooo
    */
  @throws[IOException]
  final def takeOff: Boolean = isOK(sendCommand("takeoff"))

  /**
    * land
    */
  @throws[IOException]
  final def land: Boolean = isOK(sendCommand("land"))

  /**
    * Fly up xx | xx = (20-500 cm)
    */
  @throws[IOException]
  final def up(o: Int): Boolean = isOK(sendCommand("up " + getDistance(o)))

  /**
    * Fly down xx | xx = (20-500 cm)
    */
  @throws[IOException]
  final def down(o: Int): Boolean = isOK(sendCommand("down " + getDistance(o)))

  /**
    * Fly left xx | xx = (20-500 cm)
    */
  @throws[IOException]
  final def left(o: Int): Boolean = isOK(sendCommand("left " + getDistance(o)))

  /**
    * Fly right xx | xx = (20-500 cm)
    */
  @throws[IOException]
  final def right(o: Int): Boolean = isOK(sendCommand("right " + getDistance(o)))

  /**
    * Fly forward xx | xx = (20-500 cm)
    */
  @throws[IOException]
  final def forward(o: Int): Boolean = isOK(sendCommand("forward " + getDistance(o)))

  /**
    * Fly backward xx | xx = (20-500 cm)
    */
  @throws[IOException]
  final def back(o: Int): Boolean = isOK(sendCommand("back " + getDistance(o)))

  /**
    * Rotate clockwise x° | x = (1-3600°)
    */
  @throws[IOException]
  final def cw(o: Int): Boolean = isOK(sendCommand("cw " + o))

  /**
    * Rotate counter-clockwise xx° | xx = (1-3600°)
    */
  @throws[IOException]
  final def ccw(o: Int): Boolean = isOK(sendCommand("ccw " + o))

  /**
    * Flip x l = (left) r = (right) f = (forward) b = (back) bl = (back/left) rb = (back/right) fl = (front/left) fr = (front/right)
    */
  @throws[IOException]
  final def flip(o: String): Boolean = isOK(sendCommand("flip " + o))

  /**
    * Set current speed as xx | xx = (1-100 cm/s)
    */
  @throws[IOException]
  final def setSpeed(o: Int): Boolean = isOK(sendCommand("speed " + o))

  final private def getDistance(o: Int): Int = {
    if (!isImperial) return o
    (o.toFloat * 2.54).toFloat.round
  }

  final private def isOK(strResult: String) = null != strResult && strResult == "OK"

  @throws[IOException]
  final private def sendCommand(strCommand: String): String = {
    if (null == strCommand || 0 == strCommand.length) return "empty command"
    if (!s.isConnected) return "disconnected"
    val receiveData = new Array[Byte](1024)
    val sendData = strCommand.getBytes
    val sendPacket = new DatagramPacket(sendData, sendData.length, ip, port)
    s.send(sendPacket)
    val receivePacket = new DatagramPacket(receiveData, receiveData.length)
    s.receive(receivePacket)
    val ret = new String(receivePacket.getData)
    System.out.println("Tello " + strCommand + ": " + ret)
    ret
  }

  final def close(): Unit = {
    if (null != s) s.close()
  }
}

