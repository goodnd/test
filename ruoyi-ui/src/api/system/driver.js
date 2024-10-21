import request from '@/utils/request'

// 查询运输人员管理列表
export function listDriver(query) {
  return request({
    url: '/system/driver/list',
    method: 'get',
    params: query
  })
}

// 查询运输人员管理详细
export function getDriver(id) {
  return request({
    url: '/system/driver/' + id,
    method: 'get'
  })
}

// 新增运输人员管理
export function addDriver(data) {
  return request({
    url: '/system/driver',
    method: 'post',
    data: data
  })
}

// 修改运输人员管理
export function updateDriver(data) {
  return request({
    url: '/system/driver',
    method: 'put',
    data: data
  })
}

// 删除运输人员管理
export function delDriver(id) {
  return request({
    url: '/system/driver/' + id,
    method: 'delete'
  })
}
