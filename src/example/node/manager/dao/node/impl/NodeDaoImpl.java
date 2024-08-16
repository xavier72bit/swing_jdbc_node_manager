package example.node.manager.dao.node.impl;

import example.node.manager.tool.RowMapper;
import example.node.manager.bean.Node;
import example.node.manager.dao.node.NodeDaoI;
import example.node.manager.jdbc.JdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NodeDaoImpl implements NodeDaoI {
    // select insert update delete

    @Override
    public boolean insert(Node node) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO nodes_information (node_id, node_name, node_region, node_os, node_mem_total, node_disk_total, node_bandwidth) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] args = {
                node.getNodeId(),
                node.getNodeName(),
                node.getNodeRegion(),
                node.getNodeOs(),
                node.getNodeMemTotal(),
                node.getNodeDiskTotal(),
                node.getNodeBandwidth()
        };

        return jdbcTemplate.insert(sql, args);
    }

    @Override
    public boolean delete(Node node) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "DELETE FROM nodes_information WHERE node_id = ?";
        Object[] args = {
                node.getNodeId()
        };

        return jdbcTemplate.delete(sql, args);
    }

    @Override
    public boolean update(Node node) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "UPDATE nodes_information SET node_name = ?, node_region = ?, node_os = ?, node_mem_total = ?, node_disk_total = ?, node_bandwidth = ? WHERE node_id = ?";
        Object[] args = {
                node.getNodeName(),
                node.getNodeRegion(),
                node.getNodeOs(),
                node.getNodeMemTotal(),
                node.getNodeDiskTotal(),
                node.getNodeBandwidth(),
                node.getNodeId()
        };

        return jdbcTemplate.update(sql, args);
    }

    @Override
    public Node selectOne(Node node) {
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate();

            String sql = "SELECT node_id, node_name, node_region, node_os, node_mem_total, node_disk_total, node_bandwidth FROM nodes_information WHERE node_id = ? LIMIT 0,1";
            Object[] args = {
                    node.getNodeId()
            };

            return jdbcTemplate.selectOne(sql, args, rs -> {
                try {
                    Node result = new Node();

                    result.setNodeId(rs.getString("node_id"));
                    result.setNodeName(rs.getString("node_name"));
                    result.setNodeRegion(rs.getString("node_region"));
                    result.setNodeOs(rs.getString("node_os"));
                    result.setNodeMemTotal(rs.getString("node_mem_total"));
                    result.setNodeDiskTotal(rs.getString("node_disk_total"));
                    result.setNodeBandwidth(rs.getString("node_bandwidth"));

                    return result;
                } catch (Exception e) {
                    e.printStackTrace();

                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public List<Node> selectList(Node node) {
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate();

            String sql = "SELECT node_id, node_name, node_region, node_os, node_mem_total, node_disk_total, node_bandwidth FROM nodes_information WHERE node_name LIKE ?";

            StringBuilder builder = new StringBuilder();

            builder.append("%")
                    .append(node.getNodeName())
                    .append("%");

            Object[] args = {
                    builder.toString()
            };

            return jdbcTemplate.selectList(sql, args, new RowMapper<Node>() {
                @Override
                public Node rowMap(ResultSet rs) {
                    try {
                        Node result = new Node();

                        result.setNodeId(rs.getString("node_id"));
                        result.setNodeName(rs.getString("node_name"));
                        result.setNodeRegion(rs.getString("node_region"));
                        result.setNodeOs(rs.getString("node_os"));
                        result.setNodeMemTotal(rs.getString("node_mem_total"));
                        result.setNodeDiskTotal(rs.getString("node_disk_total"));
                        result.setNodeBandwidth(rs.getString("node_bandwidth"));

                        return result;
                    } catch (Exception e) {
                        e.printStackTrace();

                        return null;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    @Override
    public List<Node> selectAll(Node node) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "SELECT node_id, node_name, node_region, node_os, node_mem_total, node_disk_total, node_bandwidth FROM nodes_information";

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("%")
                .append(node.getNodeName())
                .append("%");
        Object[] args = {
                stringBuilder.toString()
        };

        return jdbcTemplate.selectAll(sql, args, new RowMapper<Node>() {
            @Override
            public Node rowMap(ResultSet rs) {
                try{
                    Node result = new Node();

                    result.setNodeId(rs.getString("node_id"));
                    result.setNodeName(rs.getString("node_name"));
                    result.setNodeRegion(rs.getString("node_region"));
                    result.setNodeOs(rs.getString("node_os"));
                    result.setNodeMemTotal(rs.getString("node_mem_total"));
                    result.setNodeDiskTotal(rs.getString("node_disk_total"));
                    result.setNodeBandwidth(rs.getString("node_bandwidth"));

                    return result;
                } catch (Exception e){
                    e.printStackTrace();

                    return null;
                }
            }
        });
    }
}
