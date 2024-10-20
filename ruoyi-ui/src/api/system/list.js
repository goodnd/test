import request from '@/utils/request'

// 查询运输车辆列表
export function listList(query) {
  return request({
    url: '/system/list/list',
    method: 'get',
    params: query
  })
}

// 查询运输车辆详细
export function getList(id) {
  return request({
    url: '/system/list/' + id,
    method: 'get'
  })
}

// 新增运输车辆
export function addList(data) {
  return request({
    url: '/system/list',
    method: 'post',
    data: data
  })
}

// 修改运输车辆
export function updateList(data) {
  return request({
    url: '/system/list',
    method: 'put',
    data: data
  })
}

// 删除运输车辆
export function delList(id) {
  return request({
    url: '/system/list/' + id,
    method: 'delete'
  })
}
