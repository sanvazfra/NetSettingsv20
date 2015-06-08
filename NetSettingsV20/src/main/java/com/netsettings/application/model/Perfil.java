package com.netsettings.application.model;

public class Perfil {
	private String nombre = null;
	private String ip = null;
	private String mask = null;
	private String gateway = null;
	private String dnspref = null;
	private String dnsalter = null;
	private String interfaceName = null;
	private String dirproxy = null;
	private String networkName = null;
	private int comb = 0;
	
	public String getNombre() {
		return nombre;
	}
	public String getIp() {
		return ip;
	}
	public String getMask() {
		return mask;
	}
	public String getGateway() {
		return gateway;
	}
	public String getDnspref() {
		return dnspref;
	}
	public String getDnsalter() {
		return dnsalter;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public String getDirproxy() {
		return dirproxy;
	}
	public String getNetworkName() {
		return networkName;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public void setDnspref(String dnspref) {
		this.dnspref = dnspref;
	}
	public void setDnsalter(String dnsalter) {
		this.dnsalter = dnsalter;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public void setDirproxy(String dirproxy) {
		this.dirproxy = dirproxy;
	}
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}
	public int getComb() {
		return comb;
	}
	public void setComb(int comb) {
		this.comb = comb;
	}
	
}
