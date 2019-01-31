package interfaces;

import java.util.Objects;

public class RemoteRef {
    private String hostServer;
    private String hostClient;
    private String portServer;
    private String portClient;

    public RemoteRef() {
    }

    public RemoteRef(String hostServer, String hostClient, String portServer, String portClient) {
        this.hostServer = hostServer;
        this.hostClient = hostClient;
        this.portServer = portServer;
        this.portClient = portClient;
    }

    public String getHostServer() {
        return hostServer;
    }

    public void setHostServer(String hostServer) {
        this.hostServer = hostServer;
    }

    public String getHostClient() {
        return hostClient;
    }

    public void setHostClient(String hostClient) {
        this.hostClient = hostClient;
    }

    public String getPortServer() {
        return portServer;
    }

    public void setPortServer(String portServer) {
        this.portServer = portServer;
    }

    public String getPortClient() {
        return portClient;
    }

    public void setPortClient(String portClient) {
        this.portClient = portClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoteRef remoteRef = (RemoteRef) o;
        return Objects.equals(hostServer, remoteRef.hostServer) &&
                Objects.equals(hostClient, remoteRef.hostClient) &&
                Objects.equals(portServer, remoteRef.portServer) &&
                Objects.equals(portClient, remoteRef.portClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostServer, hostClient, portServer, portClient);
    }

    @Override
    public String toString() {
        return "RemoteRef{" +
                "hostServer='" + hostServer + '\'' +
                ", hostClient='" + hostClient + '\'' +
                ", portServer='" + portServer + '\'' +
                ", portClient='" + portClient + '\'' +
                '}';
    }
}