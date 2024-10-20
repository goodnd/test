import request from '@/utils/request'
// 查询所有垃圾回收站管理
export function listAllStation() {
  return request({
    url: '/system/station/listAll',
    method: 'POST',
  })
}

// 查询垃圾回收站管理列表
export function listStation(query) {
  return request({
    url: '/system/station/list',
    method: 'get',
    params: query
  })
}

// 查询垃圾回收站管理详细
export function getStation(id) {
  return request({
    url: '/system/station/' + id,
    method: 'get'
  })
}

// 新增垃圾回收站管理
export function addStation(data) {
  return request({
    url: '/system/station',
    method: 'post',
    data: data
  })
}

// 修改垃圾回收站管理
export function updateStation(data) {
  return request({
    url: '/system/station',
    method: 'put',
    data: data
  })
}

// 删除垃圾回收站管理
export function delStation(id) {
  return request({
    url: '/system/station/' + id,
    method: 'delete'
  })
}
