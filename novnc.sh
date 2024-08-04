echo "Starting noVNC Server..."

cd backend/noVNC

./utils/novnc_proxy --vnc localhost:5900 --listen localhost:6081
